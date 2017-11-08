from flask import Flask

app = Flask(__name__)

@app.route('/')

# @app.route('/success')
# def success():
#     print "hello"
#     return render_template('success.html')

def index():
    print ("got a request from the client in the index methed")
    return "response from the server"


app.run(debug = True)