from __future__ import unicode_literals
from django.shortcuts import render, HttpResponse, redirect
import datetime

def index(request):
    content = {
       "product_1":"19.99",
       "product_2":"29.99",
       "product_3":"4.99",
       "product_4":"49.99"
    }
    print content
    return render(request, "store.html", content)
def thankyou(request):
    return render(request, "checkout.html")
def buy(request):
    total = 0
    tex = request.POST['product_id']
    quantity = request.POST['quantity']
    
    if 'total' not in request.session:
        request.session['total'] = 0
    elif tex == '1000':
        price = 19.99
        total = price * int(quantity)
    elif tex == '2000':
        price = 29.99
        total = price * int(quantity)
    elif tex == '3000':
        price = 4.99
        total = price * int(quantity)
    elif tex == '4000':
        price = 49.99
        total = price * int(quantity)
    mex = int(request.session['total'])
    mex += total

    print total
    return redirect('/checkout')

# Create your views here.