import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'appFilter',
})
export class FilterPipe implements PipeTransform {
  transform(items: any[], searchTerm: any) {
    let filteredList: any[] = [];
    if (searchTerm) {
      let newSearchTerm = !isNaN(searchTerm)
        ? searchTerm.toString()
        : searchTerm.toString().toUpperCase();
      let prop;
      items.filter((item) => {
        for (let key in item) {
          if (
            item[key] === null ||
            key == 'description' ||
            key == 'id' ||
            key == 'imageUrl'
          )
            continue;
          prop = isNaN(item[key])
            ? item[key].toString().toUpperCase()
            : item[key].toString();
          if (prop.indexOf(newSearchTerm) > -1) {
            filteredList.push(item);
            return filteredList;
          }
        }
        return;
      });
      return filteredList;
    } else {
      return items;
    }
  }
}
