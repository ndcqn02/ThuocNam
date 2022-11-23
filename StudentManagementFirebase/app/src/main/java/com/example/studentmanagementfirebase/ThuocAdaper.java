package com.example.studentmanagementfirebase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.DialogPlus;

import de.hdodenhof.circleimageview.CircleImageView;

public class ThuocAdaper extends FirebaseRecyclerAdapter<ThuocNam, ThuocAdaper.ViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ThuocAdaper(@NonNull FirebaseRecyclerOptions<ThuocNam> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull ThuocNam model) {
        holder.tvtenKhoaHoc.setText(model.getTenKhoaHoc());
        holder.tvtenThuongGoi.setText(model.getTenThuongGoi());

        Glide.with(holder.imvImage.getContext())
                .load(model.getHinhAnh())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.imvImage);

        holder.tvmauLa.setText(model.getMauLa());
        holder.tvdacTinh.setText(model.getDacTinh());
        holder.tvcongDung.setText(model.getCongDung());
        holder.tvduocTinh.setText(model.getDuocTinh());
        holder.tvchuY.setText(model.getChuY());



        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.imvImage.getContext())
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.update_popup))
                        .setExpanded(true, 1800)
                        .create();

                View viewDialog = dialogPlus.getHolderView();

                EditText hinhAnh = viewDialog.findViewById(R.id.hinhAnh);
                EditText edttenThuongGoi = viewDialog.findViewById(R.id.edttenThuongGoi);
                EditText edtdacTinh = viewDialog.findViewById(R.id.edtdacTinh);
                EditText edtImage = viewDialog.findViewById(R.id.edtImage);

                Button btnUpdate = viewDialog.findViewById(R.id.btnUpdate);
                hinhAnh.setText(model.getHinhAnh());
                edttenThuongGoi.setText(model.getTenThuongGoi());
                edtdacTinh.setText(model.getDacTinh());
                edtImage.setText(model.getHinhAnh());

                dialogPlus.show();
            }
        });

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thuocnam_item, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imvImage;
        TextView tvtenKhoaHoc, tvtenThuongGoi, tvdacTinh, tvmauLa, tvcongDung, tvduocTinh, tvchuY;
        Button btnEdit, btnUpdate, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvtenKhoaHoc = itemView.findViewById(R.id.tvtenKhoaHoc);
            tvtenThuongGoi = itemView.findViewById(R.id.tvtenThuongGoi);
            imvImage = itemView.findViewById(R.id.imvImage);
            tvdacTinh = itemView.findViewById(R.id.tvdacTinh);
            tvmauLa = itemView.findViewById(R.id.tvmauLa);
            tvcongDung = itemView.findViewById(R.id.tvcongDung);
            tvduocTinh = itemView.findViewById(R.id.tvduocTinh);
            tvchuY = itemView.findViewById(R.id.tvchuY);

            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }

}
