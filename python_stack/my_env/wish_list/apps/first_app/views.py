from django.shortcuts import render, redirect
from django.core.urlresolvers import reverse
from .models import users, items
from django.contrib import messages
# Create your views here.
def index(request):
    return render(request, "login_reg.html")
def register(request):
    result = users.objects.validate_registration(request.POST)
    if type(result) == list:
        for err in result:
            messages.error(request, err)
        return redirect('/')
    request.session['user_id'] = result.id
    messages.success(request, "Logged in!!")
    users.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'] )
    return redirect("/success")

def login(request):
    result = users.objects.validate_login(request.POST)
    if type(result) == list:
        for err in result:
            messages.error(request, err)
        return redirect('/')
    request.session['user_id'] = result.id
    messages.success(request, "Successfully logged in!")
    return redirect('/success')

def success(request):
    try:
        request.session['user_id']
    except KeyError:
        return redirect('/')
    context = {
        'user': users.objects.get(id=request.session['user_id']),
        'all_users': users.objects.all().values(),
        'item': items.objects.all().values(),
    }
    return render(request, 'dash.html', context)
def addeditem(request):
    print request.POST['item']
    items.objects.create(name=request.POST['item'])
    print items.objects.all()
    return render(request, "dash.html")
def newwish(request):
    context = {
        "item" : items.objects.all().values()
    }
    return render(request, 'newwish.html', context)