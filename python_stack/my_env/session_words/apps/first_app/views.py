from django.shortcuts import render, HttpResponse, redirect
import datetime

def index(request):
    response = "Hi there!!"
    return render(request, 'page.html')
def form(request):
    if 'saved' not in request.session:
        request.session['saved'] = list()
    dt = {'time': datetime.datetime.now().strftime("%b %d %Y, %-H:%M %p")}
    # if 'checkbox' in request.session:
    #     'letter_size' = request.POST['checkbox']
    # else:
    #     html_class = request.post['color']
    request.session['saved'].append(
        {'dog':request.POST['words'],
        'color':request.POST['color'],
        'checkbox':request.POST['checkbox'],
        'time': datetime.datetime.now().strftime("%b %d %Y, %-H:%M %p")}
    )
    request.session.modified = True
    print request.session['saved']
    return redirect('/')
def clear(request):
    request.session.clear()
    try:
        request.session['tries']
    except KeyError:
        request.session['tries'] = 0
    return redirect('/')

# Create your views here.
