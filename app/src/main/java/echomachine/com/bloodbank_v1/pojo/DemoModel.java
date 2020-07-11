package echomachine.com.bloodbank_v1.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class DemoModel implements Parcelable {
    private int mImage;
    private String mText;

    public DemoModel(int mImage, String mText) {
        this.mImage = mImage;
        this.mText = mText;
    }

    public DemoModel() {
    }

    protected DemoModel(Parcel in) {
        mImage = in.readInt();
        mText = in.readString();
    }

    public static final Creator<DemoModel> CREATOR = new Creator<DemoModel>() {
        @Override
        public DemoModel createFromParcel(Parcel in) {
            return new DemoModel(in);
        }

        @Override
        public DemoModel[] newArray(int size) {
            return new DemoModel[size];
        }
    };

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImage);
        dest.writeString(mText);
    }
}
