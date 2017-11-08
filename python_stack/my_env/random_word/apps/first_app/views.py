from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string
def index(request):
    if request.method == 'GET':
        request.session['count'] = 0  
    elif request.method == 'POST':
        request.session['count'] += 1
    unique_id = get_random_string(length=14)
    context = {
        "somekey": unique_id,
        "word": request.session['count']
    }
    return render(request,'page.html', context)
def reset(request):
    try:
        del request.session['count']
        return redirect('/')
    except KeyError:
        return redirect('/')
# Create your views here.
