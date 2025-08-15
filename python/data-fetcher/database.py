import sqlite3

conn = sqlite3.connect("jobs.db")
cursor = conn.cursor()
cursor.execute("""
CREATE TABLE IF NOT EXISTS jobs (
    id TEXT PRIMARY KEY,
    title TEXT,
    company TEXT,
    description TEXT,
    summary TEXT,
    match_score TEXT,
    link TEXT,
    date_scraped TEXT
)
""")
conn.commit()
