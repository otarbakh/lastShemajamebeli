package com.example.lastshemajamebeli.adapters

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lastshemajamebeli.data.models.ChatModelDto
import com.example.roomtest.databinding.SingleUserLayoutBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class UsersAdapter : ListAdapter<ChatModelDto.ChatModelDtoItem, UsersAdapter.UsersViewHolder>(
        TeamsDiffCallBack()
    ) {



    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): UsersViewHolder {
        val binding =
            SingleUserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bindData()
    }


    inner class UsersViewHolder(private val binding: SingleUserLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var model: ChatModelDto.ChatModelDtoItem? = null
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindData() {
            model = getItem(bindingAdapterPosition)
            binding.apply {

                tvFirstName.text = "${model?.firstName} ${model?.lastName}"
                tvMessage.text = model?.lastMessage
                if(model?.updatedDate != null){
                    tvTime.text = getDate(model?.updatedDate!!,"hh:mm a")
                }
                else{
                    tvTime.text = "00:00 AM"
                }
                tvNotificationCount.text = model?.firstName
            }

        }

        fun getDate(ms:Long,dateFormat:String?):String{
            val formater = SimpleDateFormat(dateFormat)
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = ms
            return formater.format(calendar.time)
        }

    }

}
class TeamsDiffCallBack : DiffUtil.ItemCallback<ChatModelDto.ChatModelDtoItem>() {
    override fun areItemsTheSame(
        oldItem: ChatModelDto.ChatModelDtoItem,
        newItem: ChatModelDto.ChatModelDtoItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: ChatModelDto.ChatModelDtoItem,
        newItem: ChatModelDto.ChatModelDtoItem
    ): Boolean {
        return oldItem == newItem
    }
}