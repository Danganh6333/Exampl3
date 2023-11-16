package dangchph33497.fpoly.example3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class BlankFragment extends Fragment {
    private ViewPager2 viewPager;
    private int[] images = {R.drawable.bgc, R.drawable.pl2, R.drawable.sinhto};
    private int currentPage = 0;
    private Timer timer;
    private final long DELAY_MS = 2000;
    private final long PERIOD_MS = 3000;
    MusicListAdapter musicListAdapter;
    private List<DTO> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(images);
        viewPager.setAdapter(adapter);
        RecyclerView recyclerView = view.findViewById(R.id.recycle);
        musicListAdapter = new MusicListAdapter(getContext(),list);
        recyclerView.setAdapter(musicListAdapter);

        list.add(new DTO(R.drawable.pl2,"Bài hát 1","Ca Sĩ 1"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 2","Ca Sĩ 2"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 3","Ca Sĩ 3"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 4","Ca Sĩ 4"));
        list.add(new DTO(R.drawable.pl2,"Bài hát 5","Ca Sĩ 5"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Auto-scrolling task
        final Handler handler = new Handler();
        final Runnable update = () -> {
            if (currentPage == images.length) {
                currentPage = 0;
            }
            viewPager.setCurrentItem(currentPage++, true);
        };

        timer = new Timer(); // Timer to schedule auto-scrolling task
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_MS, PERIOD_MS);
        return view;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

        private int[] images;

        ImageAdapter(int[] images) {
            this.images = images;
        }

        @NonNull
        @Override
        public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
            return new ImageViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
            holder.imageView.setImageResource(images[position]);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }

        class ImageViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            ImageViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
}
