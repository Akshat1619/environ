# Generated by Django 2.1.1 on 2018-09-07 08:16

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('restapp', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='task',
            old_name='date_create',
            new_name='date_created',
        ),
    ]
