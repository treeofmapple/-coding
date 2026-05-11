import yt_dlp as youtube


def download_video(url, output_path):
    ydl_opts = {
        "cookiefile": "cookies.txt",
        "ignoreerrors": True,
        "sleep_interval": 10,
        "max_sleep_interval": 30,
        "outtmpl": f"{output_path}/%(title)s.%(ext)s",
        "format": "bestvideo+bestaudio/best",
        "merge_output_format": "mp4",
    }

    with youtube.YoutubeDL(ydl_opts) as ydl:
        info = ydl.extract_info(url, download=True)
        print(f"Download concluído: {info.get('title', 'Video')}")


def download_playlist(url, output_path):
    ydl_opts = {
        "cookiefile": "cookies.txt",
        "ignoreerrors": True,
        "outtmpl": f"{output_path}/%(playlist)s/%(playlist_index)s - %(title)s.%(ext)s",
        "format": "bestvideo+bestaudio/best",
        "merge_output_format": "mp4",
        "noplaylist": False,
        "lazy_playlist": True,
        "sleep_interval": 15,
        "max_sleep_interval": 30,
        "sleep_interval_requests": 2,
    }

    with youtube.YoutubeDL(ydl_opts) as ydl:
        info = ydl.extract_info(url, download=True)
        print(f"Download da playlist concluído: {info.get('title', 'Playlist')}")
