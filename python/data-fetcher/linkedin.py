import requests

def search_jobs(query, location, api_key):
    url = "https://serpapi.com/search.json"
    params = {
        "engine": "google_jobs",
        "q": query,
        "location": location,
        "api_key": api_key
    }
    response = requests.get(url, params=params)
    jobs = response.json().get("jobs_results", [])
    return jobs

# Example usage
if __name__ == "__main__":
    API_KEY = "your_serpapi_key"
    jobs = search_jobs("Data Scientist site:linkedin.com", "Remote", API_KEY)
    for job in jobs:
        print(f"{job['title']} at {job['company_name']} - {job['location']}")
        print(job.get('description', '')[:200])
        print(job['via'], job['job_id'])
        print("-" * 40)
