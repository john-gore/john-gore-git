from flask import Flask, render_template, request, redirect, session, flash
app = Flask(__name__)
app.secret_key = "Bobby"

@app.route('/')
def index():
  return render_template("resultvalidation.html")
# this route will handle our form submission
# notice how we defined which HTTP methods are allowed by this route
@app.route('/users', methods=['POST'])
def result():
    print "Got Post Info"
    if request.method == 'POST':
        language = request.form ['language']
        name = request.form ['name']
        location = request.form ['location']
        comment = request.form ['comment']
        if len(request.form['name']) < 1:
            flash("Name cannot be empty!")
        elif len(request.form['location']) < 1:
            flash("Location cannot be empty!")   
        elif len(request.form['language']) < 1:
            flash("Language cannot be empty!")
        elif len(request.form['comment']) < 1:
            flash("Comment cannot be empty!")
        else:
            flash('Success!')
    return render_template('result2validation.html', name = name, location = location, language = language, comment = comment)
app.run(debug=True) # run our server
