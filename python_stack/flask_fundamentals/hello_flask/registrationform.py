from flask import Flask, render_template, request, redirect, session, flash
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "Bobby"

@app.route('/', methods=['GET'])
def index():
    return render_template("registrationform.html")

@app.route('/users', methods=['POST'])
def result():
    print "Got Post Info"
    if request.method== 'POST':
        email = request.form['email']
        first_name = request.form['first_name']
        last_name = request.form['last_name']
        password = request.form['password']
        confirmpassword = request.form['confirmpassword']
        if len(request.form['email']) < 1:
            flash('Need email!')
        elif not EMAIL_REGEX.match(request.form['email']):
            flash("Invalid Email Address!")
        elif len(request.form['first_name']) < 1:
            flash('Need First Name!')
        elif request.form['first_name'].isalpha() != True:
            flash('No Numbers in Name!')
        elif len(request.form['last_name']) < 1:
            flash('Need Last Name!')
        elif request.form['last_name'].isalpha() != True:
            flash('No Numbers in Last Name!')
        elif len(request.form['password']) < 8:
            flash('Need Longer Password!')
        elif (request.form['confirmpassword']) != request.form['password']:
            flash('Need Password Confirmed!')
        else:
            flash('Success!')
        
    return render_template('registrationform2.html', email = email, first_name = first_name, last_name = last_name, password = password, confirmpassword = confirmpassword)
app.run(debug=True)