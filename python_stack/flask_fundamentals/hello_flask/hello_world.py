from flask import Flask

app = Flask(__name__)

@app.route('/')

def index():
    print ('got the request')
    return '<h1>Hello World<h1>'
    return 'My name is Anna'


app.run(debug = True)