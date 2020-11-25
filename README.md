# Sentiment Analyzer App

The app analyzes user sentiment and guages it in terms of polarity as an integer provided by python's TextBlob

There are 3 parts to this applicaion to demonstrate a good example of microservice architecture.

1: React app - Front end 
2: Java web app - Middleware app
3: Python Flask app - Backend app 

Each app is dockerized and can be deployed using the Kubernetes deployment and service files.

Command to initiate kubernnetes deployment:

```bash
kubectl apply -f <filename>
```

Command to delete deployment:

```bash
kubectl delete -f <service-filename>
```