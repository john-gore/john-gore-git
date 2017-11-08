from django.shortcuts import render, HttpResponse, redirect

def index(request):
    response = "Lets rock!"
    
    return render(request,'page.html')

def create(request):
    return render(request, 'results.html')
def process_form(request):
    try:
         request.session['tries']
    except KeyError:
        request.session['tries'] = 0
    print "*"*50
    print request.POST
    print request.POST['full_name']
    print request.POST['dojo_location']
    print request.POST['fav_lang']
    print request.POST['comment']
    unique_id = request.POST['full_name']
    dojo = request.POST['dojo_location']
    fav = request.POST['fav_lang']
    comment = request.POST['comment']
    request.session['tries'] +=1
    context = {
    "somekey": unique_id,
    "dojo": dojo,
    "fav": fav,
    "comment": comment,
    }
    return render('/result')
        
# Create your views here.
