FROM python:3.9.0
COPY ./sa /app 
WORKDIR /app 
RUN pip install -r requirements.txt
EXPOSE 5000
CMD ["python", "sentiment_analysis.py"]