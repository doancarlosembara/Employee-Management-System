import moment from "moment";

export const format_date = (value) => {
  if (value) {
    return moment(String(value)).format("YYYY-MM-DD");
  }
};
