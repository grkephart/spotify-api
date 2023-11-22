package com.spotify.api.v1.dto.responses;

import com.spotify.api.v1.dto.SpotifyItem;

public class SpotifyContentResponse<I extends SpotifyItem>
{
  private String href;
  private I[]    items;
  private int    limit;
  private String next;
  private int    offset;
  private String prev;
  private int    total;

  /**
   * @return the href
   */
  public String getHref()
  {
    return href;
  }


  /**
   * @return the items
   */
  public I[] getItems()
  {
    return items;
  }


  /**
   * @return the limit
   */
  public int getLimit()
  {
    return limit;
  }


  /**
   * @return the next
   */
  public String getNext()
  {
    return next;
  }


  /**
   * @return the offset
   */
  public int getOffset()
  {
    return offset;
  }


  /**
   * @return the prev
   */
  public String getPrev()
  {
    return prev;
  }


  /**
   * @return the total
   */
  public int getTotal()
  {
    return total;
  }

  public boolean isEmpty()
  {
    return this.items == null || this.items.length == 0;
  }

  /**
   * @param href the href to set
   */
  public void setHref(
    String href)
  {
    this.href = href;
  }


  /**
   * @param items the items to set
   */
  public void setItems(
    I[] items)
  {
    this.items = items;
  }


  /**
   * @param limit the limit to set
   */
  public void setLimit(
    int limit)
  {
    this.limit = limit;
  }


  /**
   * @param next the next to set
   */
  public void setNext(
    String next)
  {
    this.next = next;
  }


  /**
   * @param offset the offset to set
   */
  public void setOffset(
    int offset)
  {
    this.offset = offset;
  }


  /**
   * @param prev the prev to set
   */
  public void setPrev(
    String prev)
  {
    this.prev = prev;
  }


  /**
   * @param total the total to set
   */
  public void setTotal(
    int total)
  {
    this.total = total;
  }
}
