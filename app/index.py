
import json
import os

from flask import Flask, jsonify, render_template, request
from flask_cors import CORS
from google.cloud import firestore
from google.oauth2 import service_account

app = Flask(__name__)
cors = CORS(app, resource={r"/*":{"origins":"*"}})
credentials_json = json.loads(os.environ["GCP_CREDENTIALS"])
credentials = service_account.Credentials.from_service_account_info(credentials_json)
database = firestore.Client()

@app.route('/')
def swagger():
    return render_template('swagger.html')

@app.route('/visitor/count')
def count():
    return jsonify(get_count_data())

@app.route('/visitor/increment', methods=['POST'])
def increment():
    cur_count = get_count_data()
    return set_count_data(cur_count['value'] + 1)

@app.route('/visitor/load', methods=['POST'])
def load():
    return set_count_data(request.get_json().get('value', 0))

def get_count_data():
    return get_count_reference().get().to_dict()

def get_count_reference():
    return database.collection(u'visitor').document(u'count')

def set_count_data(value):
    get_count_reference().set({u'value': value})
    return count()

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=int(os.environ.get("PORT", 8080)))