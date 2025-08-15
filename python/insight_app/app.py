from flask import Flask, request, jsonify
import tweepy
from textblob import TextBlob
import os
import requests
import instaloader
from dotenv import load_dotenv

load_dotenv()
app = Flask(__name__)

# --- Twitter Setup ---
auth = tweepy.OAuth1UserHandler(
    os.getenv("TWITTER_API_KEY"),
    os.getenv("TWITTER_API_SECRET"),
    os.getenv("TWITTER_ACCESS_TOKEN"),
    os.getenv("TWITTER_ACCESS_SECRET"),
)
twitter_api = tweepy.API(auth)

@app.route("/analyze/twitter")
def analyze_twitter():
    handle = request.args.get("handle")
    tweets = twitter_api.user_timeline(screen_name=handle, count=10, tweet_mode="extended")
    results = [{
        "tweet": t.full_text,
        "sentiment": TextBlob(t.full_text).sentiment.polarity
    } for t in tweets]
    return jsonify({"handle": handle, "tweets": results})

# --- Twitch Setup ---
@app.route("/analyze/twitch")
def analyze_twitch():
    username = request.args.get("username")
    token_res = requests.post("https://id.twitch.tv/oauth2/token", params={
        "client_id": os.getenv("TWITCH_CLIENT_ID"),
        "client_secret": os.getenv("TWITCH_CLIENT_SECRET"),
        "grant_type": "client_credentials"
    }).json()

    headers = {
        "Client-ID": os.getenv("TWITCH_CLIENT_ID"),
        "Authorization": f"Bearer {token_res['access_token']}"
    }

    user_res = requests.get("https://api.twitch.tv/helix/users", headers=headers, params={"login": username}).json()
    if "data" not in user_res or not user_res["data"]:
        return jsonify({"error": "User not found"}), 404

    user = user_res["data"][0]
    return jsonify({
        "username": username,
        "display_name": user["display_name"],
        "followers": user.get("view_count", 0),
        "profile_image_url": user["profile_image_url"]
    })

# --- Instagram (public data scraping only) ---
@app.route("/analyze/instagram")
def analyze_instagram():
    username = request.args.get("username")
    loader = instaloader.Instaloader()
    try:
        profile = instaloader.Profile.from_username(loader.context, username)
        return jsonify({
            "username": profile.username,
            "followers": profile.followers,
            "bio": profile.biography,
            "is_verified": profile.is_verified
        })
    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5001)
