package dangchph33497.fpoly.example3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MusicListAdapter extends RecyclerView.Adapter<MusicListAdapter.ViewHolderOfMusicList> {
    private Context context;
    private List<DTO> list = new ArrayList<>();

    public MusicListAdapter(Context context, List<DTO> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderOfMusicList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_music,parent,false);

        ViewHolderOfMusicList viewHolderOfMusicList = new ViewHolderOfMusicList(view);
        return viewHolderOfMusicList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOfMusicList holder, int position) {
        DTO dto = list.get(position);
        holder.textArtist.setText(dto.getTenCaSi());
        holder.textTitle.setText(dto.getTenNhac());
        holder.imageMusicCover.setImageResource(dto.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolderOfMusicList extends RecyclerView.ViewHolder{
        ImageView imageMusicCover,showDetail;
        TextView textTitle,textArtist;
        public ViewHolderOfMusicList(@NonNull View itemView) {
            super(itemView);
            imageMusicCover = itemView.findViewById(R.id.imageMusicCover);
            showDetail = itemView.findViewById(R.id.showDetail);
            textTitle = itemView.findViewById(R.id.textTitle);
            textArtist = itemView.findViewById(R.id.textArtist);
        }
    }
}
