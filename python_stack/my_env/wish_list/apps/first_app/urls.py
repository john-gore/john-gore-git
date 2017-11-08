from django.conf.urls import url
from django.contrib import admin
from . import views           # This line is new!
urlpatterns = [
    url(r'^$', views.index, name='index'),
    url(r'register$',views.register, name='create'),
    url(r'login$',views.login, name='login'),
    url(r'success$', views.success, name='success'),
    url(r'^addeditem$', views.addeditem, name = 'addeditem'),
    url(r'^newwish$', views.newwish, name='newwish'),
]