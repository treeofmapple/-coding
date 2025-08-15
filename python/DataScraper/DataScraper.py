from time import sleep
import traceback
import psycopg2
import schedule
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service
from selenium.webdriver.firefox.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


def get_tradingview_data(ticker):
    service = Service(r"C:\Base\geckodriver.exe")
    options = Options()
    options.binary_location = r"C:\Program Files\Mozilla Firefox\firefox.exe"
    driver = webdriver.Firefox(service=service, options=options)

    url = f"https://www.tradingview.com/symbols/{ticker}/"
    driver.get(url)

    try:
        wait = WebDriverWait(driver, 10)
        price_element = wait.until(EC.presence_of_element_located((By.CLASS_NAME, "tv-symbol-price-quote__value")))
        change_element = wait.until(EC.presence_of_element_located((By.CLASS_NAME, "js-symbol-change")))
        price = price_element.text
        change = change_element.text
        
        return {
            "ticker": ticker,
            "price": float(price.replace(",", "")),
            "change": float(change.strip('%')),
        }
    except Exception as e:
        print(f"Error fetching data for {ticker}: {e}")
        traceback.print_exc()
        print("Page source:")
        print(driver.page_source)
        return None
    finally:
        driver.quit()


def insert_into_database(data):
    try:
        with psycopg2.connect(
            host='ep-sparkling-grass-a5brm6e7.us-east-2.aws.neon.tech',
            dbname='trading',
            user='trading_owner',
            password='lqnbWQUTw9N0'
        ) as connection:
            with connection.cursor() as cursor:
                sql = """
                    INSERT INTO stock_data (ticker, price, change_percentage)
                    VALUES (%s, %s, %s)
                """
                cursor.execute(sql, (data["ticker"], data["price"], data["change"]))
                connection.commit()
                print("Data inserted successfully.")
    except Exception as e:
        print(f"Database error: {e}")
        traceback.print_exc()


def job():
    print("Fetching data...")
    stock_data = get_tradingview_data("AAPL")
    if stock_data:
        insert_into_database(stock_data)
        print("Data fetched and saved.")


schedule.every(5).minutes.do(job)

if __name__ == "__main__":
    print("Data fetcher started, running once")
    try:
        job()
        while True:
            schedule.run_pending()
            sleep(1)
    except KeyboardInterrupt:
        print("\nKeyboardInterrupt detected. Exiting program gracefully...")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        traceback.print_exc()
    finally:
        print("Program terminated.")