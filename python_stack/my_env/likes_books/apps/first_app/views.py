from django.shortcuts import render, HttpResponse, redirect
def index(request):
    response = "hello!"
    return HttpRepsonse(response)

# Create your views here.
