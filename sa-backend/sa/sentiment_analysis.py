from textblob import TextBlob
from flask import Flask, request, jsonify
from flask_cors import CORS
import requests
import os
import nltk

nltk.download('punkt')
app = Flask(__name__)
CORS(app)
WEBAPP_URL =  "http://localhost:8080" if os.getenv('WEBAPP_URL') == None else os.getenv('WEBAPP_URL')

@app.route("/testHealth")
def hello():
	return jsonify(
		statusCode="200",
		message="Backend Services are up and running."
	)

@app.route("/testComms", methods=['GET'])
def verify_comms_local():
	try:
		print(WEBAPP_URL)
		response = requests.get(WEBAPP_URL+"/testHealth")
	except requests.exceptions.RequestException as err:
		print("Exception")

	return response.text if (not requests.exceptions.RequestException) and (response and response.ok) else jsonify(
		statusCode= "500",
		message="Middleware Services are down."
	)

@app.route("/analyse/sentiment", methods=['POST'])
def analyse_sentiment():
	sentence = request.get_json()['sentence']
	polarity = TextBlob(sentence).sentences[0].polarity
	return jsonify(
		sentence=sentence,
		polarity=polarity
	)

@app.route("/analyse", methods=['GET']) 
def analyse_sentiment_get(): 
	sentence = request.args.get('sentence') 
	polarity = TextBlob(sentence).sentences[0].polarity 
	return str(polarity)

if __name__ == '__main__':
	app.run(host='0.0.0.0', port=5000)