package ma.fstt.marketplace.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserSupplier extends User implements Parcelable {

    private String raisonSociale;

    public UserSupplier(Integer nUtilisateur, String username, String password, String email, String postalAddress, String rib, String raisonSociale) {
        this.username=username;
        this.password=password;
        this.email=email;
        this.postalAddress=postalAddress;
        this.type="fo";
        this.rib=rib;
        this.raisonSociale=raisonSociale;
        this.nUtilisateur = nUtilisateur;
    }
    public Integer getnUtilisateur() {
        return this.nUtilisateur;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPostalAddress(){
        return this.postalAddress;
    }
    public String getRib(){
        return this.rib;
    }
    public String getRaisonSociale(){
        return this.raisonSociale;
    }

    protected UserSupplier(Parcel in) {
        nUtilisateur = in.readInt();
        username = in.readString();
        password = in.readString();
        email = in.readString();
        postalAddress = in.readString();
        rib = in.readString();
        raisonSociale = in.readString();
    }

    public static final Creator<UserSupplier> CREATOR = new Creator<UserSupplier>() {
        @Override
        public UserSupplier createFromParcel(Parcel in) {
            return new UserSupplier(in);
        }

        @Override
        public UserSupplier[] newArray(int size) {
            return new UserSupplier[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.nUtilisateur);
        dest.writeString(this.username);
        dest.writeString(this.password);
        dest.writeString(this.email);
        dest.writeString(this.postalAddress);
        dest.writeString(this.rib);
        dest.writeString(this.raisonSociale);
    }
}
