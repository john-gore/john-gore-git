from django.shortcuts import render, HttpResponse, redirect
from django.core.urlresolvers import reverse
from .models import Blog
from django.contrib import messages
def index(request):
    all_users = { 'all_users': Blog.objects.all().values() }
    print Blog.objects.all()
    return render(request, 'landingpage.html', context = all_users)
def new(request):
    return render(request, 'adduser.html')
def addnew(request):
    Blog.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'], email=request.POST['email'] )
    return render(request, 'adduser.html')
def show(request):
    return render(request, 'showuser.html')
def edit(request):
    return render(request, 'edituser.html')
def user_edit(request):
    return redirect('/edit')
def delete(request, id):
    Blog.objects.get(id=id).delete()
    return redirect("/index")
# Create your views here.
