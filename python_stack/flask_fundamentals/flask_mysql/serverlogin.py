from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
import re
import md5

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "texas"
mysql = MySQLConnector(app,'registration')
@app.route('/')
def index():
    query = "SELECT * FROM user"                           
    email = mysql.query_db(query)                           
    # run query with query_db()
    return render_template('indexlogin.html')
@app.route('/email', methods=['POST'])
def create():
    query = "SELECT * FROM user"
    form_email = request.form['email']
    form_first_name = request.form['first_name']
    password = md5.new(request.form['password']).hexdigest()
    form_last_name = request.form['last_name']
    form_email = request.form['email']
    form_password = request.form['password']
    form_passconfirm = request.form['passwordconfirm']
    is_valid = True
    
    data = {
        'email': request.form['email'],
        'first' : request.form['first_name'],
        'last' : request.form['last_name'],
        'password' : request.form['password']
    }
    y = {'email': request.form['email']}
    email_from_db = mysql.query_db("SELECT email FROM user WHERE email = :email", y)
    
    if len(email_from_db) > 0:
        print('Email found')
        flash('Email already exists!')
        is_valid = False
        print 2  
    if len(form_email) < 1:
        print('2')
        # blank entry
        flash("Email is required!")
        is_valid = False
    if not EMAIL_REGEX.match(form_email):
        print('3')
        flash("Invalid email entered!")
        is_valid = False
    if len(form_first_name) < 2:
        print ('First Name not long enough')
        is_valid = False
    if len(form_last_name) < 2:
        print ('Last Name not long enough')
        is_valid = False
    if len(form_password) < 8:
        print ('Password to short')
        is_valid = False
    if form_password != form_passconfirm:
        flash("Password not confirmed!")
        is_valid = False
    if is_valid:
        print('4')
        flash("success!")
        # save the email
        insertquery = "INSERT INTO user (email, first_name, last_name, password, created_at, apdated_at) VALUES (:email, :first_name, :last_name, :password, NOW(), NOW())"
        data = {
            'email': form_email,
            'first_name' : form_first_name,
            'last_name' : form_last_name,
            'password' : password
        }
        mysql.query_db(insertquery, data)
        flash("You just entered {} as a valid email".format(form_email))
        return render_template('successlogin.html', user = query)
    return redirect('/')
@app.route('/done', methods =['POST'])
def done():
    query = "SELECT * FROM user"
    form_email = request.form['email']
    password = md5.new(request.form['password']).hexdigest()
    form_password = request.form['password']
    is_valid = True

    y = {'email': request.form['email'], 'password': password}
    x = {'password': password}
    email_from_db = mysql.query_db("SELECT email FROM user WHERE email = :email AND password = :password", y)
    pass_from_db = mysql.query_db("SELECT password FROM user WHERE password = :password", x)
    data = {
        'email': request.form['email'],
        'password': request.form['password']
    }
    if len(email_from_db) > 0:
        print('Email found')
        flash('Email already exists!')
        is_valid = False
        print 2
    if len(pass_from_db) > 0:
        print('Email found')
        flash('Email already exists!')
        is_valid = False
        print 50
    flash('Login Success')
    
    return render_template('indexlogin2.html')
app.run(debug=True)