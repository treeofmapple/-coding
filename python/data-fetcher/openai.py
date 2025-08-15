from openai import OpenAI

def filter_jobs_with_ai(jobs, profile_description):
    prompt = "These are some job descriptions:\n\n"
    for i, job in enumerate(jobs[:5]):
        prompt += f"Job {i+1}: {job['title']} at {job['company_name']}\n{job['description']}\n\n"

    prompt += f"\nBased on this profile: {profile_description}, which jobs are the best match and why?"

    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[{"role": "user", "content": prompt}]
    )

    return response.choices[0].message["content"]


def match_score(resume_text, job_description):
    prompt = f"Resume:\n{resume_text}\n\nJob Description:\n{job_description}\n\nRate the match from 0 to 10 and explain why."
    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[{"role": "user", "content": prompt}]
    )
    return response.choices[0].message["content"]

def summarize_job(job_description):
    prompt = f"Summarize this job in 3 bullet points:\n{job_description}"
    response = openai.ChatCompletion.create(
        model="gpt-4",
        messages=[{"role": "user", "content": prompt}]
    )
    return response.choices[0].message["content"]
