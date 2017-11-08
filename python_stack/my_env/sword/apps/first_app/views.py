from django.shortcuts import render, HttpResponse, redirect

def index(request):
    response = "Placeholder to later display all the lists of blogs!!"
    return HttpResponse(response)

def index2(request):
    response = "placeholder to display a new form to create a new blog"
    return HttpResponse(response)
def create(request):
    return redirect ('/')
def number(request):
    response = "Placeholder to display a blog 15!"
    return HttpResponse(response)
def edit(request):
    response = "Placeholder to edit blog 15!"
    return HttpResponse(response)
def delete(request):
    response = "Destroy"
    return HttpResponse(response)
# Create your views here.
