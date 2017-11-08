from flask import Flask, render_template, session, redirect, request
import random
from datetime import datetime
from collections import defaultdict

app = Flask(__name__)
app.secret_key = 'bobbyhill2'

@app.route('/')
def index():
    if 'gold_sum' not in session:
        session['gold_sum'] = 0
        session['activities'] = list()
        print 43
    return render_template('ninjagold.html', gold = session['gold_sum'])


@app.route('/process_money', methods=['POST'])
def gold():
    building = request.form['building']
    act_dict = dict()
    gold = 0
    if request.form['building'] == 'farm':
       gold = random.randint(10,20)
    elif request.form['building'] == 'cave':
        gold = random.randint(5,10)
    elif request.form['building'] == 'house':
        gold = random.randint(2,5)
    elif request.form['building'] == 'casino':
        gold = random.randint(-50,50)
    if building != 'casino':
        act_dict['classname'] = 'lostmoney'
        act_dict['content'] = 'Earned {} gold from the {}! ({})'.format(gold, building, datetime.now())
    else:
        if gold < 0:
            act_dict['class_name'] = 'lostmoney'
            act_dict['content'] = 'Entered a Casino and lost {} at {}!!'.format(gold, datetime.now())   
        else:
            act_dict['classname'] = 'mademoney'
            act_dict['content'] = "Won {} at the Casino at {}!!!".format(gold, datetime.now())
            print ('You won {} at the Casino at {}!!').format(session['gold_sum'], datetime.now())
    session['activities'].append(act_dict)
    session['gold_sum']+= gold
    return redirect('/')
app.run(debug=True)