<script setup>
import { RouterLink } from "vue-router";
const props = defineProps({
  item: Object,
});
console.log(props.item.thumbnail);
</script>

<template>
  <div class="item">
    <RouterLink
      :to="{ name: 'MyListDetail', params: { pid: item.pid }, query: { title: item.title } }"
    >
      <!-- <div>{{ item.title }}</div> -->
      <img v-if="item.thumbnail" :src="item.thumbnail" alt="" />
      <img v-else class="tmpimg" src="@/assets/logo0.svg" alt="" />

      <p>{{ item.title }}</p>
    </RouterLink>
  </div>
</template>

<style lang="scss" scoped>
.item {
  background-color: white;
  font-weight: bold;
  img {
    border-radius: 10px;
    width: 100%;
    height: 100%;

    opacity: 1;
    object-fit: cover;

    &:hover {
      opacity: 0.7;
    }
  }

  p {
    display: flex;
    justify-content: center;
    font-size: 25px;
  }
}

.tmpimg {
  border: 2px solid var(--main-color);
}

:hover {
  color: var(--main-color);
  text-decoration: none;
  font-weight: lighter;
}
</style>
