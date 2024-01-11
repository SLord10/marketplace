package ma.fstt.marketplace.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ma.fstt.marketplace.R;
import ma.fstt.marketplace.model.UserClient;

public class UtilisateurAcPages extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private UserClient utilisateur;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        init();
        bottomNav.setSelectedItemId(R.id.nav_home);
    }

    private void init(){
        bottomNav= findViewById(R.id.container_items_bottom);
        intent= getIntent();
        utilisateur=(UserClient)intent.getParcelableExtra("utilisateur");
        ecouteurBottomNav();
    }

    private void ecouteurBottomNav() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragmentSelected=null;
                switch(item.getItemId()){
                    case R.id.nav_home:
                        fragmentSelected= new Fragment_Home_UtilAc(utilisateur);
                        break;
                    case R.id.nav_basket:
                        fragmentSelected= new Fragment_Basket_UtilAc(utilisateur);
                        break;
                    case R.id.nav_account:
                        fragmentSelected= new Fragment_profil_UtilAc(utilisateur);
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragments_container, fragmentSelected).commit();
                return true;
            }
        });
    }
}
