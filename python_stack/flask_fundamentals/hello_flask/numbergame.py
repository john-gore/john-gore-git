from flask import Flask, render_template, session, redirect, request
import random

app = Flask(__name__)
app.secret_key = 'bobbyhill2'

@app.route('/')
def index():
    if 'sec_num' not in session:
        session['sec_num'] = random.randint(1,101)
    if 'guessed' not in session:
        session['hintBox'] = 'hintBoxWrong'
    return render_template('numbergame.html')

@app.route('/guess', methods=['POST'])
def guess():
    the_guess = int(request.form['number'])
    if the_guess == session['sec_num']:
        session['hint'] = "{} was the number!".format(the_guess)
        session['guessed'] = True
        session['hintbox'] = 'hintBoxRight'
    elif the_guess < session['sec_num']:
        session['hint'] = "Too low!"
    elif the_guess > session['sec_num']:
        session['hint'] = "Too High!"
    return redirect('/')

@app.route('/reset', methods=['POST'])
def reset():
    session.clear()
    return redirect('/')

app.run(debug=True)