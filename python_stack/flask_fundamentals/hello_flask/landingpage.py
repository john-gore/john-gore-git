from flask import Flask,render_template

app = Flask(__name__)

@app.route('/')
def index():
    print "Request confirmed"
    return '<h3>Welcome to my portfolio! My name is John!<h3>'

@app.route('/ninjas')
def projects():
    return render_template('ninjas.html')

@app.route('/news')
def about():
    return render_template('news.html')

app.run(debug = True)