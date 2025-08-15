import schedule
import time

def job():
    print("Running daily job scrape and match...")
    # call your job fetching, matching, emailing functions here

schedule.every().day.at("08:00").do(job)

while True:
    schedule.run_pending()
    time.sleep(60)
