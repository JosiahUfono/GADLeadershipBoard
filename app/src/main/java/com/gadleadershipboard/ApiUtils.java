import android.os.AsyncTask;
import android.widget.ImageView;

import com.gadleadershipboard.HerokuAPI;
import com.gadleadershipboard.HoursUtils;
import com.gadleadershipboard.R;
import com.gadleadershipboard.SkillUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {
    public static class GadsApiUtils {

            public static final String GADS_API_BASE_URL = "https://gadsapi.herokuapp.com/api/";
            public static final String GOOGLE_FORM_API_BASE_URL = "https://docs.google.com/forms/d/e/";

            public static Retrofit mRetrofitGads = new Retrofit
                    .Builder()
                    .baseUrl(GADS_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            public static Retrofit mRetrofitGoogleForm = new Retrofit
                    .Builder()
                    .baseUrl(GOOGLE_FORM_API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            public static HerokuAPI mLeadersAPI = mRetrofitGads.create(HerokuAPI.class);
            public static HerokuAPI mProjectSubmissionAPI = mRetrofitGoogleForm.create(HerokuAPI.class);

            public static Call<Void> submitProject(String fName, String lName, String email, String link) {
                return mProjectSubmissionAPI.submitForm(fName, lName, email, link);
            }

            public static Call<List<HoursUtils>> fetchLearningLeaders() {
                return mLeadersAPI.getHoursUtils();
            }

            public static Call<List<SkillUtils>> fetchSkillIQLeaders() {
                return mLeadersAPI.getSkillUtils();
            }
        }

        public static class ImagesUtility {
            public static void loadImage(ImageView imageView, String imageUrl) {
                Picasso
                        .get()
                        .load(imageUrl)
                        .fit()
                        .placeholder(R.color.colorAccent)
                        .into(imageView)
                ;
            }
        }
}
