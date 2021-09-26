
from flask import Flask, jsonify, render_template
from flask_cors import CORS

app = Flask(__name__)
cors = CORS(app, resource={r"/*":{"origins":"*"}})

@app.route('/')
def swagger():
    return render_template('swagger.html')

@app.route('/test')
def test():
    return jsonify({'result': 1})

if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=int(os.environ.get("PORT", 8080)))