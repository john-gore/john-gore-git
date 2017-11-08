from django.shortcuts import render, redirect
from django.core.urlresolvers import reverse
from ..first_app.models import users, items
from django.contrib import messages
# Create your views here.
def index(request):
    return render(request, "indexfirst.html")
def additem(request):
    return render(request, "userwishes.html")
