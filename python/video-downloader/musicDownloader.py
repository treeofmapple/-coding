import yt_dlp as youtube


def download_music(url, output_path):
    ydl_opts = {
        "cookiefile": "cookies.txt",
        "ignoreerrors": True,
        "download_archive": "downloaded_songs.txt",
        "outtmpl": f"{output_path}/%(title)s.%(ext)s",
        "format": "bestaudio[ext=m4a]/bestaudio/best",
        "sleep_interval": 10,
        "max_sleep_interval": 30,
        "extractor_args": {"youtube": {"player_client": ["android", "web"]}},
        "postprocessors": [
            {
                "key": "FFmpegExtractAudio",
                "preferredcodec": "mp3",
                "preferredquality": "320",
            }
        ],
    }

    with youtube.YoutubeDL(ydl_opts) as ydl:
        info = ydl.extract_info(url, download=True)
        print(f"Download concluído: {info.get('title', 'Audio')}.mp3")


def download_music_playlist(url, output_path):
    ydl_opts = {
        "cookiefile": "cookies.txt",
        "ignoreerrors": True,
        "outtmpl": f"{output_path}/%(playlist)s/%(playlist_index)s - %(title)s.%(ext)s",
        "format": "bestaudio[ext=m4a]/bestaudio/best",
        "download_archive": "downloaded_songs.txt",
        "noplaylist": False,
        "lazy_playlist": True,
        "sleep_interval": 15,
        "max_sleep_interval": 30,
        "sleep_interval_requests": 2,
        "extractor_args": {"youtube": {"player_client": ["android", "web"]}},
        "postprocessors": [
            {
                "key": "FFmpegExtractAudio",
                "preferredcodec": "mp3",
                "preferredquality": "320",
            }
        ],
    }

    with youtube.YoutubeDL(ydl_opts) as ydl:
        info = ydl.extract_info(url, download=True)
        print(f"Download da playlist concluído: {info.get('title', 'Playlist')}")
