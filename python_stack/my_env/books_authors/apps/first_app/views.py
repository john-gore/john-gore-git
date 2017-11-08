from django.shortcuts import render, HttpResponse, redirect
def index(request):
    response = "hi!"
    return HttpResponse(response)

# Create your views here.
