using System;
using Android.App;
using Android.OS;
//using Android.Widget;
using Android.Runtime;
using Android.Views;
using AndroidX.AppCompat.Widget;
using AndroidX.AppCompat.App;
using Google.Android.Material.FloatingActionButton;
using Google.Android.Material.Snackbar;

namespace App2
{
    [Activity(Label = "@string/app_name", Theme = "@style/AppTheme.NoActionBar", MainLauncher = true)]
    public class MainActivity : AppCompatActivity
    {
        int count = 0;
        string[] ideas = { "En app der Giver mig en lyst til at leve", "En app der laver apps", "En app der minder dig om at lave apps", 
            "En app der giver dig komplimenter til at booste din lave selvtillid",
            "En app der Roaster dig, fordi du ikke fortjener at være glad" ,"App der laver dig", "Plat eller krone", "Fuck dig, find din egen idé, Bitch"
        , "Simp-dataBase_app", "Simp gif app", "Random Billder fra folk"};
        AppCompatTextView ideaBox;
        protected override void OnCreate(Bundle savedInstanceState)
        {
                        base.OnCreate(savedInstanceState);
            Xamarin.Essentials.Platform.Init(this, savedInstanceState);
            SetContentView(Resource.Layout.activity_main);
            ideaBox = FindViewById<AppCompatTextView>(Resource.Id.textView1);
            AppCompatButton but = FindViewById<AppCompatButton>(Resource.Id.button1);
            but.Click += butOnClick;
            Toolbar toolbar = FindViewById<Toolbar>(Resource.Id.toolbar);
            SetSupportActionBar(toolbar);
          /*  
            FloatingActionButton fab = FindViewById<FloatingActionButton>(Resource.Id.fab);
            fab.Click += FabOnClick;*/
            
        }

        public override bool OnCreateOptionsMenu(IMenu menu)
        {
            
            /* MenuInflater.Inflate(Resource.Menu.menu_main, menu);*/
            return true;
            
        }

        public override bool OnOptionsItemSelected(IMenuItem item)
        {
            int id = item.ItemId;
            if (id == Resource.Id.action_settings)
            {
                return true;
            }

            return base.OnOptionsItemSelected(item);
        }
        private void butOnClick(object sender, EventArgs eventArgs)
        {
            Random rnd = new Random();
            int num = rnd.Next(0, ideas.Length);
            ideaBox.Text = ideas[num];
        }

        private void FabOnClick(object sender, EventArgs eventArgs)
        {
            count++;
           /* View view = (View) sender;
            Snackbar.Make(view, count.ToString(), Snackbar.LengthLong)
               .SetAction("Action", (View.IOnClickListener)null).Show();*/
        }
    
        public override void OnRequestPermissionsResult(int requestCode, string[] permissions, [GeneratedEnum] Android.Content.PM.Permission[] grantResults)
        {
            Xamarin.Essentials.Platform.OnRequestPermissionsResult(requestCode, permissions, grantResults);

            base.OnRequestPermissionsResult(requestCode, permissions, grantResults);
        }
	}
}
