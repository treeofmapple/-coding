import yt_dlp as youtube


def download_video(url, output_path):
    ydl_opts = {
        "cookiefile": "cookies.txt",
        "ignoreerrors": True,
        "sleep_interval": 10,
        "max_sleep_interval": 30,
        "download_archive": "downloaded_songs.txt",
        "outtmpl": f"{output_path}/%(title)s.%(ext)s",
        "format": "bestvideo*[ext=mp4]+bestaudio[ext=m4a]/best[ext=mp4]/best",
        "merge_output_format": "mp4",
        "extractor_args": {"youtube": {"player_client": ["android", "web"]}},
    }

    with youtube.YoutubeDL(ydl_opts) as ydl:
        info = ydl.extract_info(url, download=True)
        print(f"Download concluído: {info.get('title', 'Video')}")


def download_playlist(url, output_path):
    ydl_opts = {
        "cookiefile": "cookies.txt",
        "ignoreerrors": True,
        "outtmpl": f"{output_path}/%(playlist)s/%(playlist_index)s - %(title)s.%(ext)s",
        "format": "bestvideo*[ext=mp4]+bestaudio[ext=m4a]/best[ext=mp4]/best",
        "download_archive": "downloaded_songs.txt",
        "merge_output_format": "mp4",
        "noplaylist": False,
        "lazy_playlist": True,
        "sleep_interval": 15,
        "max_sleep_interval": 30,
        "sleep_interval_requests": 2,
        "extractor_args": {"youtube": {"player_client": ["android", "web"]}},
    }

    with youtube.YoutubeDL(ydl_opts) as ydl:
        info = ydl.extract_info(url, download=True)
        print(f"Download da playlist concluído: {info.get('title', 'Playlist')}")
