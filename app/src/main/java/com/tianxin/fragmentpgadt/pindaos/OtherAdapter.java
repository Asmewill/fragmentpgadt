package com.tianxin.fragmentpgadt.pindaos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tianxin.fragmentpgadt.R;
import com.tianxin.fragmentpgadt.observes.TestObServernotice;

import java.util.List;

/**
 * 作者：created by meixi
 * 邮箱：15913707499@163.com
 * 日期：2019/6/3 14
 */

public class OtherAdapter extends BaseAdapter {

    private Context context;
    public List<String> channelList;
    private TextView item_text;
    /** 是否可见 在移动动画完毕之前不可见，动画完毕后可见*/
    boolean isVisible = true;
    /** 要删除的position */
    public int remove_position = -1;
    /** 是否是用户频道 */
    private boolean isUser = false;

    public OtherAdapter(Context context, List<String> channelList ,boolean isUser) {
        this.context = context;
        this.channelList = channelList;
        this.isUser = isUser;
    }

    @Override
    public int getCount() {
        return channelList == null ? 0 : channelList.size();
    }

    @Override
    public String getItem(int position) {
        if (channelList != null && channelList.size() != 0) {
            return channelList.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_channel, null);
        item_text = (TextView) view.findViewById(R.id.text_item);
        String channel = getItem(position);
        item_text.setText(channel);
        if(isUser){
            if ((position == 0) || (position == 1)){
                item_text.setEnabled(false);
            }
        }
        if (!isVisible && (position == -1 + channelList.size())){
            item_text.setText("");
            item_text.setSelected(true);
            item_text.setEnabled(true);
        }
        if(remove_position == position){
            item_text.setText("");
        }
        return view;
    }

    /** 获取频道列表 */
    public List<String> getChannnelLst() {
        return channelList;
    }

    /** 添加频道列表 */
    public void addItem(String channel) {
        channelList.add(channel);
        notifyDataSetChanged();
    }

    /** 设置删除的position */
    public void setRemove(int position) {
        remove_position = position;
        notifyDataSetChanged();
        // notifyDataSetChanged();
    }

    /** 删除频道列表 */
    public void remove() {
        channelList.remove(remove_position);
        remove_position = -1;
        TestObServernotice.getInstance().notifyObserver(112, 1, "6666", null,channelList);
        notifyDataSetChanged();
    }
    /** 设置频道列表 */
    public void setListDate(List<String> list) {
        channelList = list;
    }

    /** 获取是否可见 */
    public boolean isVisible() {
        return isVisible;
    }

    /** 设置是否可见 */
    public void setVisible(boolean visible) {
        isVisible = visible;
    }

}
