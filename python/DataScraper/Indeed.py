from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.support import expected_conditions as EC
from selenium.webdriver.common.ui import webDriverWait
from bs4 import BeautifulSoup
import time
import pandas as pd

driver = webDriver.Firefox("C:\Base\geckodriver.exe")

driver.get('https://ca.indeed.com/')

soup = BeautifulSoup(driver.page_source, 'lxml')

boxes = soup.find_all('div', class_ = 'job_seen_beacon')
len(boxes)

df = pd.DataFrame({'Link':[''], 'Job Title':[''], 'Company':[''], 'DatePosted':[''], 'Location':['']})

for i in boxes:
    link = i.find('a').get('href')
    job_title = i.find('a', class_ = 'jcs-JobTitle css-jspxzf eu4oa1w0').text
    company = i.find('span', class_ =  'companyName').text
    location = i.find('div', class_ = 'companyLocation').text
    date_posted = i.find('span', class_ = 'date').text
    df = df.append({''})
    break





