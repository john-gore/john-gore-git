from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)

@app.route('/')
def index():
  return render_template("result.html")
# this route will handle our form submission
# notice how we defined which HTTP methods are allowed by this route
@app.route('/users', methods=['POST'])
def result():
   print "Got Post Info"
   if request.method == 'POST':
       name = request.form ['name']
       location = request.form ['location']
       language = request.form ['language']
       comment = request.form ['comment']
   return render_template('result2.html', name = name, location = location, language = language, comment = comment)
app.run(debug=True) # run our server
