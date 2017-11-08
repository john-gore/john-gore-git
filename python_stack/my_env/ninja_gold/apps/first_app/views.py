from django.shortcuts import render, HttpResponse, redirect
import random
def index(request):
    request.session['gold'] = 0
    
    return render(request, 'page.html')
def find(request):
    print random.randint(0,50)
    print request.POST['building']
    
    return redirect('/')

# Create your views here.
