from flask import Flask, render_template, redirect, request

app= Flask(__name__)
app.secret_key

@app.route('/')
def index():
    return render_template('colorpicker.html')

@app.route('/color', methods=['POST'])
def colorpick():
    return redirect('/')


app.run(debug=True)