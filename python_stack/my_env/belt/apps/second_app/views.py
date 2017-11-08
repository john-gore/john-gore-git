from django.shortcuts import render, HttpResponse, redirect
from django.core.urlresolvers import reverse
from ..first_app.models import users, reviews, books
from django.contrib import messages

def index(request):
    return render(request, "login.html")

def bookreview(request):
    return render(request, "bookreviews.html")

def addreview(request):
    # print request.POST['book_title']
    # print request.POST['author']
    # print request.POST['review']
    # print request.POST['number']
    # books.objects.create(title=request.POST['book_title'], author=request.POST['author'])
    # reviews.objects.create(comment = request.POST['review'], rating = 3)
    return render(request, 'addreview.html')
def submitreview(request):
    print request.POST['book_title']
    print request.POST['author']
    print request.POST['review']
    print request.POST['number']
    return render(request, 'addreview.html')

def register(request):
    print request.POST['review']
    return render(request, 'userreview.html')

# Create your views here.
