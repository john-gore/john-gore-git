from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
import re
import md5

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "texas"
mysql = MySQLConnector(app,'Databasedaig')
@app.route('/')
def index():
    query = "SELECT * FROM users"                           
    email = mysql.query_db(query)                           
    # run query with query_db()
    return render_template('thewall.html')
@app.route('/register', methods=['POST'])
def create():
    query = "SELECT * FROM users"
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
    email_from_db = mysql.query_db("SELECT email FROM users WHERE email = :email", y)
    
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
        insertquery = "INSERT INTO users (email, first_name, last_name, password, created_at, updated_at) VALUES (:email, :first_name, :last_name, :password, NOW(), NOW())"
        data = {
            'email': form_email,
            'first_name' : form_first_name,
            'last_name' : form_last_name,
            'password' : password
        }
        mysql.query_db(insertquery, data)
        flash("You just entered {} as a valid email".format(form_email))
        return render_template('thewall2.html', user = query)
    return redirect('/')
@app.route('/login', methods =['POST'])
def done():
    query = "SELECT * FROM users"
    form_email = request.form['email']
    password = md5.new(request.form['password']).hexdigest()
    form_password = request.form['password']
    form_passconfirm = password
    is_valid = True

    y = {'email': request.form['email']}
    x = {'password': password}
    pass_from_db = mysql.query_db("SELECT id, password FROM users WHERE email = :email", y)
    
    session['link'] = pass_from_db[0]['id']
    print session
    print pass_from_db[0]['id']
    data = {
        'email': request.form['email'],
        'password': request.form['password']
    }
    if len(form_email) == 0:
        print('Email found')
        flash('Email worked!')
        is_valid = False
    if len(pass_from_db) == 0:
        print('Email found')
        flash('Password worked!')
        is_valid = False
    if pass_from_db[0]['password'] != password:
        flash("Password not confirmed!")
        is_valid = False
    if is_valid:
        return render_template('thewall2.html')
    else:
        return redirect('/')


@app.route('/posted', methods =['POST'])
def carve():
    user_login = session['link']
    message = request.form['message']
    
    querycarve = "INSERT INTO messages (users_id, message, created_at, updated_at) VALUES (:user_login, :message, NOW(), NOW())"
    data = {
        'user_login': session['link'],
        'message': message,
    }
    
    mysql.query_db(querycarve, data)
    querytree = "SELECT users_id, message, first_name, last_name FROM messages JOIN users ON users_id = users.id"
    messages = mysql.query_db(querytree)

    return render_template('thewall2.html', messages = messages)

@app.route('/nail', methods =['POST'])
def nail():
    user_name = session['link']
    comment = request.form['comment']
    
    querynail = "INSERT INTO comments (message_id, users_id, comment, created_at, updated_at) VALUES (:message_id, :username, :comment, NOW(), NOW())"
    



    # y = {'comment': request.form['comment']} 
    # message_from_db = mysql.query_db("SELECT users_id FROM comments WHERE comment = :comment", y)
    
   
    


    return render_template('thewall2.html')
app.run(debug=True)